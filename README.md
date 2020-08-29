# LuckyTripTest
## app architecture 
* KOTLIN,
* ANDROIDX,
* MVVM,
* KOIN, 
* RETROFIT, 
* Material Design,
* coroutines,
* reactive programming using coroutines and live data,
* KOTLINX-serialization


# Outcome
- To Produce a standalone application using the Java programming language,
- Android Studio development environment and LuckyTrip API.
-  Any 3rd party libraries are also ok to use if you think they are of benefit.
- All the information needed to complete the test will be provided to you in this document.
---------------
# Overview
A user of your app should be able to see a list of rooms (Room picker) populated in a RecyclerView which displays the following:
1. Room name
2. Room description
3. Room max occupancy
4. Room price with its currency
5. All the room bed configurations
-------------
The user should be able to select any room from the list and Once a room is selected, display the following information on the screen for the user to see:
1. Room name
2.  Room price with its currency 
3.  One of the room photos
-------------
- Your app should be made up of at least 2 screens; a home/introduction screen and a room picker screen

- The documentation for the rooms endpoint can be found in the attached “Rooms Documentation.html” file.

- An example response for the rooms endpoint can be found in the same document.
----------------
##### Home screen
- A screen which displays information the user has selected
- The layout of this screen is largely up to you, however it needs to directly link to the room picker screen
---------------------
##### Room picker
- A screen containing a RecyclerView populated by data from https://devapi.luckytrip.co.uk/test/rooms endpoint
- API doc https://htmlpreview.github.io/?https://raw.githubusercontent.com/hnabtiti/LuckyTripTest/master/api_rooms_documentation.html?token=ABIUAHY5A6UPJAJH2YDQIWC7JIXSY
- A room cell should consist of the data mentioned previously.
- Selecting a room should close the room picker screen and display the selected information on the home screen.
-----------------------------
# Bonus
- Room picker items to be sorted depending on the max_occupancy in ascending order.
- Show the last selected room on app open
-  Taking into consideration the User Experience is a plus !
- Make it look awesome and pretty!
---------------------------
