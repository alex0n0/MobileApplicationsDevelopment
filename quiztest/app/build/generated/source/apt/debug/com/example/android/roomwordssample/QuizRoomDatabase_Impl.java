package com.example.android.roomwordssample;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class QuizRoomDatabase_Impl extends QuizRoomDatabase {
  private volatile QuizDao _quizDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `quiz_table` (`id` INTEGER NOT NULL, `topic` INTEGER NOT NULL, `isMcq` INTEGER NOT NULL, `image` INTEGER NOT NULL, `answer` INTEGER NOT NULL, `question` TEXT, `option1` TEXT, `option2` TEXT, `option3` TEXT, `option4` TEXT, `explanation` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"6fc2dadebfcb07bc0e1f13e63b7ea080\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `quiz_table`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsQuizTable = new HashMap<String, TableInfo.Column>(11);
        _columnsQuizTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsQuizTable.put("topic", new TableInfo.Column("topic", "INTEGER", true, 0));
        _columnsQuizTable.put("isMcq", new TableInfo.Column("isMcq", "INTEGER", true, 0));
        _columnsQuizTable.put("image", new TableInfo.Column("image", "INTEGER", true, 0));
        _columnsQuizTable.put("answer", new TableInfo.Column("answer", "INTEGER", true, 0));
        _columnsQuizTable.put("question", new TableInfo.Column("question", "TEXT", false, 0));
        _columnsQuizTable.put("option1", new TableInfo.Column("option1", "TEXT", false, 0));
        _columnsQuizTable.put("option2", new TableInfo.Column("option2", "TEXT", false, 0));
        _columnsQuizTable.put("option3", new TableInfo.Column("option3", "TEXT", false, 0));
        _columnsQuizTable.put("option4", new TableInfo.Column("option4", "TEXT", false, 0));
        _columnsQuizTable.put("explanation", new TableInfo.Column("explanation", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysQuizTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesQuizTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoQuizTable = new TableInfo("quiz_table", _columnsQuizTable, _foreignKeysQuizTable, _indicesQuizTable);
        final TableInfo _existingQuizTable = TableInfo.read(_db, "quiz_table");
        if (! _infoQuizTable.equals(_existingQuizTable)) {
          throw new IllegalStateException("Migration didn't properly handle quiz_table(com.example.android.roomwordssample.Quiz).\n"
                  + " Expected:\n" + _infoQuizTable + "\n"
                  + " Found:\n" + _existingQuizTable);
        }
      }
    }, "6fc2dadebfcb07bc0e1f13e63b7ea080", "fd78eb01b53fcdb3bf403e9bc73fa73e");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "quiz_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `quiz_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public QuizDao quizDao() {
    if (_quizDao != null) {
      return _quizDao;
    } else {
      synchronized(this) {
        if(_quizDao == null) {
          _quizDao = new QuizDao_Impl(this);
        }
        return _quizDao;
      }
    }
  }
}
