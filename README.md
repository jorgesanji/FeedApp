# FeedApp

This App does searching on iTunes API, later shown all of those on a list which can be sorted by genre, duration, and price.

The app architecture is MVP in order decouple model from the view.

There are 4 main folders:

- Bussines .-  business logical or use cases
- Data .- database or rest API
- DI .- dependency injection
- UI .- views (fragments, activities, custom views), presenter

The Presenter does the communication between the model with the view, it manipulates the model in order to deliver proper data to the view.

In order to retrieve data from iTunes API, this app uses retrofit + rx.

This app uses this endpoint from the iTunes API
https://itunes.apple.com/search?term = "query"

iTunes documentation 
https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/#searchexamples



