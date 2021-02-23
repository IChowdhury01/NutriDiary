// This is a React component that will hold all of a particular user's logs.
// By default, it will show the user's log for today. 
// The user flip through all past logs with navigation arrows.
// A calendar button can be used to navigate to a specific day.

import React, { Component } from 'react';   // Inherit from the React component class.

// Each instance of a React component is unique.
class Logs extends Component {  
    // The internal data of the component, stored in object fields. These fields are used to hold data from the database or track the component's current status.
    state = {   
        isLoading : true,   // Tracks whether the component has fully loaded. True by default.
        // User: "",   // Holds the user's name. 
        Logs : []   // Array that holds all of this user's logs. Empty by default.
     }    
    
    
    // Now we make requests to the backend (through the API endpoints) to fetch data from the database, and store it in the React component.
    // 2 types of calls: 
    // Synchronous calls halt the entire application until a response comes back. 
    // Asynchronous calls allow the user to keep using the site. Asynchronous = better user interaction
        async componentDidMount() {
        const response = await fetch('/api/logs');  // Send an asynchronous request to the /api/logs endpoint to find all logs in the database. Wait for the async request to complete, then store the response in a constant. 
        const body = await response.json(); // Store the serialized response in another const.
        this.setState({Logs: body, isLoading: false});  // Must use setState to change React component fields. Store logs data in the component and mark component loading complete.
    }
     
    // This method determines how the component's data is displayed on a webpage.
    // The index.js page calls this render function to display the component on index.html
    render() {     
        // Copy data to local variables. 
        const isLoading = this.state.isLoading;
        const Logs = this.state.Logs;
        
        // Check if the component has fully loaded. If it hasn't display a loading message.
        if(isLoading) {
            return "Loading..."
        }

        // Once the component has fully loaded, render the following JSX code (HTML-esque React code) on the webpage.
        return ( 
            <div>
                <h1>All Logs</h1>
                {   // Brackets hold dynamic content that isn't always the same.
                    Logs.map(   // The map function iterates through each element in the JSON.
                        log =>  // Lambda function. Create a parameter "log" to hold each JSON element. 
                            <div id = {log.id}> 
                                <p>Date: {log.logDate}</p>
                                <p>Weight: {log.weight} pounds</p>
                                <p>Calories: {log.calories} kcal</p>
                                <p>Protein: {log.protein}g</p>
                            </div>  // Create a div and display each log field inside it.
                    )
                }
            </div>
         );
    }
}
 
export default Logs;   // How the component is exported for use in a webpage.