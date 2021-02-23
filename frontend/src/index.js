import React from 'react';
import ReactDOM from 'react-dom';

import './index.css';
import 'bootstrap/dist/css/bootstrap.css';  // Import bootstrap
import { ChakraProvider } from "@chakra-ui/react" // Import Chakra-UI library

import reportWebVitals from './reportWebVitals';
import Home from './Home' // Make the index.html home page use this React component. 

// Initialize Chakra-UI
function App() {
  return (
    <ChakraProvider>
      <App />
    </ChakraProvider>
  )
}

// ReactDOM is a virtual DOM that tracks the webpage's state, then renders React components onto the real webpage's DOM.
ReactDOM.render(  // Find the HTML element in index.html with the ID "root" (the main div in body). Then render the Logs React component onto it.
  <React.StrictMode>
    <Home />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();