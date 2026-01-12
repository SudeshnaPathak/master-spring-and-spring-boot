import { Component } from 'react';

//Class based component
export default class FourthComponent extends Component{
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


