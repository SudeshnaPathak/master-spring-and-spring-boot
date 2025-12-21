import './App.css';
import Counter from './components/counter/Counter';

//App is the parent component
function App() {

  //Specify CSS Class - ClassName (instead of class in HTML)
  return (
    <div className="App">
      <Counter />
    </div> 
  );
}

export default App;

//Rest components are child components of App component

