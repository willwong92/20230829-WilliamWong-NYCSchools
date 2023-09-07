# 20230829-WilliamWong-NYCSchools

# Architecture: MVVM
The architecture of choice is MVVM as it follows best practices for separating concerns while also
making scalability, maintainability, and testing much more feasible.
- View - Observes data pushes from the viewmodel and handles UI based on the UI state object returned.
  Also responsible for displaying any errors
- ViewModel - Pattern Model-View-ViewModel (MVVM) facilitating separation of development between 
data and view layers
- Data Layer - Handles data operations asynchronously.
- Unidirectional data flow (UDF), where state flows down to the data layer and events flow up to the
view layer.
- A single-activity architecture, using the Navigation component
- App architecture supports facilitates modularity to allow development of features in isolation, 
separate from other features.

# Some good practices that MVVM follows are:
- Keeps viewmodels unaware of any references to the view.
- View only serves as an observer to the viewmodel.
- Repository serves as the single source of truth for data and handles business logic.
- Expose information about the UI state using a UI state holder class.

# Libraries
- Kotlin - Official programming language for Android development.
- Navigation - Used for handling interactions between fragments like navigating, back-pressing, and
  facilitates type safety when passing data between destinations.
- Coroutines - Concurrency design pattern used for asynchronous development.
- Flow - Used for data streams and emits sequentially.
- Android Architecture Components - MVVM supported collection of libraries that facilitates the 
design of robust, testable, and maintainable components.
- LiveData - Used to observe any data from the data layer.
- ViewModel - Stores UI related data and propagates them to the UI.
- ViewBinding - Used to generate a binding class for each XML layout file present in that module and
  allows you to more easily write code that interacts with views. I found this to be particularly
  useful as it removes a lot of boilerplate
- Room - For offline support/caching.
- Hilt - Used to generate dependencies and to facilitate testing.
- Retrofit2 - For network operations like fetching data from the NASA Image Api.
- Gson - For Json Parsing.
- Gson Converter - Used for serializing data objects from JSON.
- MockK - Kotlin supported mocking library used for mocking dependencies during testing.
- JUnit4 - Unit testing library.

#Notes
I mainly focused on app architecture and design patterns given that features such as displaying the 
main feed and navigating to details require connection to separate REST endpoints hence the 
distinction between home and detailed view. For the sake of memory and loading speeds I reduced
the search results to 20 since the data count was significantly large which could result in 
dodgy performance in the home screen. Given more time I would've incorporated paging which would 
load the home page in chunks rather than all at once, thus improving performance. Perhaps a search
feature would be useful if the student knows which school they are looking for as well.

# How to Run/Build
- Download the zip file
- Open using Android Studio
- Build and run the app.