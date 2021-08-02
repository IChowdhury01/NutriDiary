import React, { Component } from 'react';
import NavBar from './NavBar';

// React component for the home page.
class Home extends Component {
    state = {  }
    render() { 
        return ( 
            <NavBar/>   // Render the NavBar component onto any webpage that renders this component. 
        );
    }
}
 
export default Home;
