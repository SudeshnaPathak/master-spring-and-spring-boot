import './App.css';
import { Component } from 'react';

//Function based components

//App is the parent component
function App() {
  //JSX Elements must have closing tags
  //return() : parenthesis makes it easy to write multi-line JSX ~ Why Parenthesis?
  //lowercase tag names refer to HTML elements
  //Uppercase Component names refer to user-defined components
  //Specify CSS Class - ClassName (instead of class in HTML)
  return (
    <div className="App">
      <FirstComponent />
      <SecondComponent />
      <ThirdComponent />
      <FourthComponent />
    </div> // JSX element/tag
  );
}

//Rest components are child components of App component
function FirstComponent(){
  // Whatever we return here will be displayed by this component
  // We return JSX view from here
  return (
    <div className="FirstComponent">First Component</div> // JSX element/tag
  );
}

function SecondComponent(){
  return (
    <div className="SecondComponent">Second Component</div>
  );
}

//Class based components

class ThirdComponent extends Component{
  render(){
    return (
      <div className="ThirdComponent">Third Component</div>
    );
  }
}

class FourthComponent extends Component{
  render(){
    return (
      // Wrapping multiple JSX elements inside an empty wrapper<>, as JSX expressions must have only one parent element, i.e one top-level tag
      // We cannot return multiple JSX tags/elements from a component
      <>
        <div className="FourthComponent">Fourth Component</div>
        <div className="FourthComponent">Fourth Component</div>
      </>
    );
  }
}

export default App;
