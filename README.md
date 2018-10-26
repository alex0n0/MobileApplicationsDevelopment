# MobileApplicationsDevelopment
INFS3634 App READ ME & General Guidelines

Optimised for Android 5.0 (Lollipop) and above.
Best experienced on a mobile device.

Overall Features and Functions

1.	Easy to use navigation with the complete navigation drawer available in every activity and also the home page navigation for quick access.
2.	Topic content is separated into modules, with text and a YouTube video to accompany through the YouTube API. A YouTube playlist of all videos can also be found in a single place for easy access.
3.	A multiple-choice quiz utilising a room database which randomised answers, so answers were in different spots and not repeated from the recyclerview.
4.	Feedback is given through an overall mark and also a review process which allows students to gain a complete understanding of which questions were correct/incorrect.
5.	A Flickr API is implemented to provide additional resources for students, through images.
6.	A consistent colour scheme and easy to use layout for great UX.



General Guidelines and Justifications on App Development

1.	The navigation drawer was first constructed with the default android activity, which was expanded to incorporate more items in the menu. Intents were required to link item clicks to different activities. These were made within a base navigation activity which other activities extended it to inherit the navigation drawer. The home page navigation drawer was built similarly but instead with onscreen buttons that would lead to other activities. The navigation drawer acted as an overall, “always there” form of navigation whilst the home page was for quick access upon app launch.

2.	Topic contents were separated into modules, which utilised an array list to display the list of topics with headings and sub headings. On clicks are required to trigger an intent which leads the user to an activity in which textviews and a YouTube Player Fragment are populated with data determined from the array. Adapters were used to transport these items from the array list. The playlist was generated through YouTube API methods which allowed the extracting of thumbnail data, with further onClicks used to grab video IDs and use them to populate a YouTube player

3.	The multiple-choice quiz utilised a room database which set out the questions and answers, with an array list and adapter to display them within a list view. A view model was used to display the topic separation. Questions were categorised per topic and an onclick on the chosen topic, powered by switch statements, would populate the following list view with the respective questions. Async tasks must be used in order to load quiz in the background as to not make the app appear to hang as it inserted the data into a Dao which handles the database interactions.


4.	Feedback was provided through counts of correct and incorrect answers, displayed through a simple, easy to understand textview. A button was implemented to navigate to a review page which used an adapter to display a list view of the questions within the module, showing which ones were answered correctly and incorrectly. Explanations were also populated depending on the question through putExtra methods within the intents.

5.	The Flickr API was implemented through an array list and adapter to populate and required the use of a JSON file in order to extract data and images from a website. The array adapter and list view displayed thumbnails of JSON data that was extracted, with onClicks used to inflate the view to show the individual resources. The downloading was required to be executed within Async tasks to not “hang” the app, with the status being communicated within the activity to facilitate the downloads.

6.	In order to create a great UX experience, the app was designed with a consistent colour scheme. The UI was furthered by intuitive positioning of buttons and prompts, so users would never be confused about using the app. This required minimal clutter within activities, with logical progression of activities and their functions as to not over complicate the app.
