package com.example.android.roomwordssample;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import android.support.annotation.NonNull;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public class QuizDao_Impl implements QuizDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfQuiz;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public QuizDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfQuiz = new EntityInsertionAdapter<Quiz>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `quiz_table`(`id`,`topic`,`isMcq`,`image`,`answer`,`question`,`option1`,`option2`,`option3`,`option4`,`explanation`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Quiz value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getTopic());
        final int _tmp;
        _tmp = value.getIsMcq() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        final int _tmp_1;
        _tmp_1 = value.getImage() ? 1 : 0;
        stmt.bindLong(4, _tmp_1);
        stmt.bindLong(5, value.getAnswer());
        if (value.getQuestion() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getQuestion());
        }
        if (value.getOption1() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getOption1());
        }
        if (value.getOption2() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getOption2());
        }
        if (value.getOption3() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getOption3());
        }
        if (value.getOption4() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getOption4());
        }
        if (value.getExplanation() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getExplanation());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM quiz_table";
        return _query;
      }
    };
  }

  @Override
  public void insert(Quiz quiz) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfQuiz.insert(quiz);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Quiz>> getTopicAll() {
    final String _sql = "SELECT * from quiz_table ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Quiz>>() {
      private Observer _observer;

      @Override
      protected List<Quiz> compute() {
        if (_observer == null) {
          _observer = new Observer("quiz_table") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfTopic = _cursor.getColumnIndexOrThrow("topic");
          final int _cursorIndexOfIsMcq = _cursor.getColumnIndexOrThrow("isMcq");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
          final int _cursorIndexOfAnswer = _cursor.getColumnIndexOrThrow("answer");
          final int _cursorIndexOfQuestion = _cursor.getColumnIndexOrThrow("question");
          final int _cursorIndexOfOption1 = _cursor.getColumnIndexOrThrow("option1");
          final int _cursorIndexOfOption2 = _cursor.getColumnIndexOrThrow("option2");
          final int _cursorIndexOfOption3 = _cursor.getColumnIndexOrThrow("option3");
          final int _cursorIndexOfOption4 = _cursor.getColumnIndexOrThrow("option4");
          final int _cursorIndexOfExplanation = _cursor.getColumnIndexOrThrow("explanation");
          final List<Quiz> _result = new ArrayList<Quiz>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Quiz _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpTopic;
            _tmpTopic = _cursor.getInt(_cursorIndexOfTopic);
            final boolean _tmpIsMcq;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsMcq);
            _tmpIsMcq = _tmp != 0;
            final boolean _tmpImage;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfImage);
            _tmpImage = _tmp_1 != 0;
            final int _tmpAnswer;
            _tmpAnswer = _cursor.getInt(_cursorIndexOfAnswer);
            final String _tmpQuestion;
            _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
            final String _tmpOption1;
            _tmpOption1 = _cursor.getString(_cursorIndexOfOption1);
            final String _tmpOption2;
            _tmpOption2 = _cursor.getString(_cursorIndexOfOption2);
            final String _tmpOption3;
            _tmpOption3 = _cursor.getString(_cursorIndexOfOption3);
            final String _tmpOption4;
            _tmpOption4 = _cursor.getString(_cursorIndexOfOption4);
            final String _tmpExplanation;
            _tmpExplanation = _cursor.getString(_cursorIndexOfExplanation);
            _item = new Quiz(_tmpId,_tmpTopic,_tmpIsMcq,_tmpImage,_tmpAnswer,_tmpQuestion,_tmpOption1,_tmpOption2,_tmpOption3,_tmpOption4,_tmpExplanation);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<List<Quiz>> getTopic1() {
    final String _sql = "SELECT * from quiz_table WHERE topic ='1' ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Quiz>>() {
      private Observer _observer;

      @Override
      protected List<Quiz> compute() {
        if (_observer == null) {
          _observer = new Observer("quiz_table") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfTopic = _cursor.getColumnIndexOrThrow("topic");
          final int _cursorIndexOfIsMcq = _cursor.getColumnIndexOrThrow("isMcq");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
          final int _cursorIndexOfAnswer = _cursor.getColumnIndexOrThrow("answer");
          final int _cursorIndexOfQuestion = _cursor.getColumnIndexOrThrow("question");
          final int _cursorIndexOfOption1 = _cursor.getColumnIndexOrThrow("option1");
          final int _cursorIndexOfOption2 = _cursor.getColumnIndexOrThrow("option2");
          final int _cursorIndexOfOption3 = _cursor.getColumnIndexOrThrow("option3");
          final int _cursorIndexOfOption4 = _cursor.getColumnIndexOrThrow("option4");
          final int _cursorIndexOfExplanation = _cursor.getColumnIndexOrThrow("explanation");
          final List<Quiz> _result = new ArrayList<Quiz>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Quiz _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpTopic;
            _tmpTopic = _cursor.getInt(_cursorIndexOfTopic);
            final boolean _tmpIsMcq;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsMcq);
            _tmpIsMcq = _tmp != 0;
            final boolean _tmpImage;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfImage);
            _tmpImage = _tmp_1 != 0;
            final int _tmpAnswer;
            _tmpAnswer = _cursor.getInt(_cursorIndexOfAnswer);
            final String _tmpQuestion;
            _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
            final String _tmpOption1;
            _tmpOption1 = _cursor.getString(_cursorIndexOfOption1);
            final String _tmpOption2;
            _tmpOption2 = _cursor.getString(_cursorIndexOfOption2);
            final String _tmpOption3;
            _tmpOption3 = _cursor.getString(_cursorIndexOfOption3);
            final String _tmpOption4;
            _tmpOption4 = _cursor.getString(_cursorIndexOfOption4);
            final String _tmpExplanation;
            _tmpExplanation = _cursor.getString(_cursorIndexOfExplanation);
            _item = new Quiz(_tmpId,_tmpTopic,_tmpIsMcq,_tmpImage,_tmpAnswer,_tmpQuestion,_tmpOption1,_tmpOption2,_tmpOption3,_tmpOption4,_tmpExplanation);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<List<Quiz>> getTopic2() {
    final String _sql = "SELECT * from quiz_table WHERE topic ='2' ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Quiz>>() {
      private Observer _observer;

      @Override
      protected List<Quiz> compute() {
        if (_observer == null) {
          _observer = new Observer("quiz_table") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfTopic = _cursor.getColumnIndexOrThrow("topic");
          final int _cursorIndexOfIsMcq = _cursor.getColumnIndexOrThrow("isMcq");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
          final int _cursorIndexOfAnswer = _cursor.getColumnIndexOrThrow("answer");
          final int _cursorIndexOfQuestion = _cursor.getColumnIndexOrThrow("question");
          final int _cursorIndexOfOption1 = _cursor.getColumnIndexOrThrow("option1");
          final int _cursorIndexOfOption2 = _cursor.getColumnIndexOrThrow("option2");
          final int _cursorIndexOfOption3 = _cursor.getColumnIndexOrThrow("option3");
          final int _cursorIndexOfOption4 = _cursor.getColumnIndexOrThrow("option4");
          final int _cursorIndexOfExplanation = _cursor.getColumnIndexOrThrow("explanation");
          final List<Quiz> _result = new ArrayList<Quiz>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Quiz _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpTopic;
            _tmpTopic = _cursor.getInt(_cursorIndexOfTopic);
            final boolean _tmpIsMcq;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsMcq);
            _tmpIsMcq = _tmp != 0;
            final boolean _tmpImage;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfImage);
            _tmpImage = _tmp_1 != 0;
            final int _tmpAnswer;
            _tmpAnswer = _cursor.getInt(_cursorIndexOfAnswer);
            final String _tmpQuestion;
            _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
            final String _tmpOption1;
            _tmpOption1 = _cursor.getString(_cursorIndexOfOption1);
            final String _tmpOption2;
            _tmpOption2 = _cursor.getString(_cursorIndexOfOption2);
            final String _tmpOption3;
            _tmpOption3 = _cursor.getString(_cursorIndexOfOption3);
            final String _tmpOption4;
            _tmpOption4 = _cursor.getString(_cursorIndexOfOption4);
            final String _tmpExplanation;
            _tmpExplanation = _cursor.getString(_cursorIndexOfExplanation);
            _item = new Quiz(_tmpId,_tmpTopic,_tmpIsMcq,_tmpImage,_tmpAnswer,_tmpQuestion,_tmpOption1,_tmpOption2,_tmpOption3,_tmpOption4,_tmpExplanation);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<List<Quiz>> getTopic3() {
    final String _sql = "SELECT * from quiz_table WHERE topic ='3' ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Quiz>>() {
      private Observer _observer;

      @Override
      protected List<Quiz> compute() {
        if (_observer == null) {
          _observer = new Observer("quiz_table") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfTopic = _cursor.getColumnIndexOrThrow("topic");
          final int _cursorIndexOfIsMcq = _cursor.getColumnIndexOrThrow("isMcq");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
          final int _cursorIndexOfAnswer = _cursor.getColumnIndexOrThrow("answer");
          final int _cursorIndexOfQuestion = _cursor.getColumnIndexOrThrow("question");
          final int _cursorIndexOfOption1 = _cursor.getColumnIndexOrThrow("option1");
          final int _cursorIndexOfOption2 = _cursor.getColumnIndexOrThrow("option2");
          final int _cursorIndexOfOption3 = _cursor.getColumnIndexOrThrow("option3");
          final int _cursorIndexOfOption4 = _cursor.getColumnIndexOrThrow("option4");
          final int _cursorIndexOfExplanation = _cursor.getColumnIndexOrThrow("explanation");
          final List<Quiz> _result = new ArrayList<Quiz>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Quiz _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpTopic;
            _tmpTopic = _cursor.getInt(_cursorIndexOfTopic);
            final boolean _tmpIsMcq;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsMcq);
            _tmpIsMcq = _tmp != 0;
            final boolean _tmpImage;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfImage);
            _tmpImage = _tmp_1 != 0;
            final int _tmpAnswer;
            _tmpAnswer = _cursor.getInt(_cursorIndexOfAnswer);
            final String _tmpQuestion;
            _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
            final String _tmpOption1;
            _tmpOption1 = _cursor.getString(_cursorIndexOfOption1);
            final String _tmpOption2;
            _tmpOption2 = _cursor.getString(_cursorIndexOfOption2);
            final String _tmpOption3;
            _tmpOption3 = _cursor.getString(_cursorIndexOfOption3);
            final String _tmpOption4;
            _tmpOption4 = _cursor.getString(_cursorIndexOfOption4);
            final String _tmpExplanation;
            _tmpExplanation = _cursor.getString(_cursorIndexOfExplanation);
            _item = new Quiz(_tmpId,_tmpTopic,_tmpIsMcq,_tmpImage,_tmpAnswer,_tmpQuestion,_tmpOption1,_tmpOption2,_tmpOption3,_tmpOption4,_tmpExplanation);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<List<Quiz>> getTopic4() {
    final String _sql = "SELECT * from quiz_table WHERE topic ='4' ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Quiz>>() {
      private Observer _observer;

      @Override
      protected List<Quiz> compute() {
        if (_observer == null) {
          _observer = new Observer("quiz_table") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfTopic = _cursor.getColumnIndexOrThrow("topic");
          final int _cursorIndexOfIsMcq = _cursor.getColumnIndexOrThrow("isMcq");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
          final int _cursorIndexOfAnswer = _cursor.getColumnIndexOrThrow("answer");
          final int _cursorIndexOfQuestion = _cursor.getColumnIndexOrThrow("question");
          final int _cursorIndexOfOption1 = _cursor.getColumnIndexOrThrow("option1");
          final int _cursorIndexOfOption2 = _cursor.getColumnIndexOrThrow("option2");
          final int _cursorIndexOfOption3 = _cursor.getColumnIndexOrThrow("option3");
          final int _cursorIndexOfOption4 = _cursor.getColumnIndexOrThrow("option4");
          final int _cursorIndexOfExplanation = _cursor.getColumnIndexOrThrow("explanation");
          final List<Quiz> _result = new ArrayList<Quiz>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Quiz _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpTopic;
            _tmpTopic = _cursor.getInt(_cursorIndexOfTopic);
            final boolean _tmpIsMcq;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsMcq);
            _tmpIsMcq = _tmp != 0;
            final boolean _tmpImage;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfImage);
            _tmpImage = _tmp_1 != 0;
            final int _tmpAnswer;
            _tmpAnswer = _cursor.getInt(_cursorIndexOfAnswer);
            final String _tmpQuestion;
            _tmpQuestion = _cursor.getString(_cursorIndexOfQuestion);
            final String _tmpOption1;
            _tmpOption1 = _cursor.getString(_cursorIndexOfOption1);
            final String _tmpOption2;
            _tmpOption2 = _cursor.getString(_cursorIndexOfOption2);
            final String _tmpOption3;
            _tmpOption3 = _cursor.getString(_cursorIndexOfOption3);
            final String _tmpOption4;
            _tmpOption4 = _cursor.getString(_cursorIndexOfOption4);
            final String _tmpExplanation;
            _tmpExplanation = _cursor.getString(_cursorIndexOfExplanation);
            _item = new Quiz(_tmpId,_tmpTopic,_tmpIsMcq,_tmpImage,_tmpAnswer,_tmpQuestion,_tmpOption1,_tmpOption2,_tmpOption3,_tmpOption4,_tmpExplanation);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
