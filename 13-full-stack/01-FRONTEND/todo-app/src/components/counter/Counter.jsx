import { useState } from 'react'
import './Counter.css'

export default function Counter({by = 1})
{
    // useState is a React Hook that allows us to add state to functional components.
    // It returns an array with two elements: the current state value and a function to update that state value.
    //Eg : [0 , f]
    const [count , setCount] = useState(0); // Initializing count state variable to 0

    function incrementCounterFunction()
    {
        setCount(count + by) //We are calling the setCount function to update the count state variable
    }

    function decrementCounterFunction()
    {
        if(count - by >= 0)
        setCount(count - by)
    }

    return (
        <div className="Counter">
            <span className="count">{count}</span> 
            <div>
                <button className="counterButton" 
                onClick={incrementCounterFunction}
                // style = {buttonStyle}
                >+{by} </button>
                 <button className="counterButton" 
                onClick={decrementCounterFunction}
                >-{by} </button>
            </div>
        </div>
    )
}


//  If we use parentheses here like incrementCounterFunction() , the function will be called during the rendering itself which is not what we want. We want to call it only when the button is clicked.

// Two options to style in React:
// 1. Using CSS file (as done here) - Counter.css 
// 2. Using inline styles (as commented out in the button element)


// const buttonStyle = {
//     'fontSize' : '16px',
//     'backgroundColor' : '#00a5ab',
//     'width' : '100px',
//     'margin' : '10px',          
//     'color' : 'white',
//     'padding' : '15px',
//     'borderRadius' : '30px'
// }

// style attribute in JSX takes a JavaScript object instead of a string as in HTML. Hence we define buttonStyle as an object and pass it to the style attribute.

//In HTML, A HTML page is represented as a DOM (Document Object Model) tree structure. Each element in HTML is a node in the DOM. We need to update the DOM to update in the UI. But updating the DOM is an expensive operation.

//React uses a Virtual DOM(kept in memory) which is a lightweight copy of the actual DOM. When the state of a component changes, React updates the Virtual DOM first. It then compares the updated Virtual DOM with the previous version of the Virtual DOM to find out what has changed. Finally, it updates only those parts of the actual DOM that have changed. This process is called Reconciliation and it makes React very efficient.We are not directly manipulating the DOM, instead we are updating the state and React identifies the changes and updates the DOM accordingly.