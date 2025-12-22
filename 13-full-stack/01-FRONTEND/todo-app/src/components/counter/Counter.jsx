import { useState } from 'react'
import CounterButton from './CounterButton'
import './Counter.css'


export default function Counter()
{
    // useState is a React Hook that allows us to add state to functional components.
    // It returns an array with two elements: the current state value and a function to update that state value.
    //Eg : [0 , f] where 0 is the initial value of the state variable and f is the function to update the state variable.

    const [count , setCount] = useState(0); // -> State , initial value of count is 0

    //-> Logic to increment , decrement and reset the counter

    function incrementCounterParentFunction(by) 
    {
        setCount(count + by) //We are calling the setCount function to update the count state variable
    }

    function decrementCounterParentFunction(by)
    {
        //To prevent count from going negative
        if(count - by >= 0) setCount(count - by)
        else setCount(0)
    }

    function resetCounter()
    {
        setCount(0)
    }

    return(
        <>
            <CounterButton by={1} 
            incrementMethod = {incrementCounterParentFunction} 
            decrementMethod = {decrementCounterParentFunction}/>
            <CounterButton by={2} 
            incrementMethod = {incrementCounterParentFunction} 
            decrementMethod = {decrementCounterParentFunction}/>
            <CounterButton by={5} 
            incrementMethod = {incrementCounterParentFunction} 
            decrementMethod = {decrementCounterParentFunction}/>
            <span className="totalCount">{count}</span> 
            <div>
            <button className="resetButton" onClick={resetCounter}>Reset</button>
            </div>
        </>
    ) //-> View
}


// Two options to style in React:
// 1. Using CSS file (as done here) - Counter.css 
// 2. Using inline styles using style attribute inside the element 

//HTML vs React DOM Manipulation:

//In HTML, A HTML page is represented as a DOM (Document Object Model) tree structure. Each element in HTML is a node in the DOM. We need to update the DOM to update in the UI. But updating the DOM is an expensive operation.

//React uses a Virtual DOM(kept in memory) which is a lightweight copy of the actual DOM. When the state of a component changes, React updates the Virtual DOM first. It then compares the updated Virtual DOM with the previous version of the Virtual DOM to find out what has changed. Finally, it updates only those parts of the actual DOM that have changed. This process is called Reconciliation and it makes React very efficient.We are not directly manipulating the DOM, instead we are updating the state and React identifies the changes and updates the DOM accordingly.