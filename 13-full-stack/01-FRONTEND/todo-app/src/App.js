import './App.css';
import TodoApp from './components/todo/TodoApp.jsx';

//App is the parent component
function App() {

  //Specify CSS Class - ClassName ->Styling
  
  return (
    <div className="App">
      <TodoApp/>
    </div> 
  ) 
}

//Rest components are child components of App component

//Props in React:

//<PlayingWithProps property1 = "value1" property2 = "value2"/>

// {property1 : "value1", property2 : "value2"} object is passed as props to PlayingWithProps component
// function PlayingWithProps(properties)
// {
//   console.log(properties)
//   console.log(properties.property1)
//   console.log(properties.property2)
//   return (
//     <div>Props</div>
//   );
// }

// Destructuring props object to directly get property1 and property2
// function PlayingWithProps({property1, property2})
// {
//   console.log(property1)
//   console.log(property2)
//   return (
//     <div>Props</div>
//   );
// }

export default App


