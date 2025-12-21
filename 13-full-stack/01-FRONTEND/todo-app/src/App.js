import './App.css';
import LearningComponent from './components/learning-examples/LearningComponent';

//App is the parent component
function App() {

  //Specify CSS Class - ClassName (instead of class in HTML)
  return (
    <div className="App">
      <LearningComponent />
    </div> 
  );
}

export default App;

//Rest components are child components of App component

