import { useState } from 'react';
import './Counter.css';

export default function Counter()
{
    // useState is a React Hook that allows us to add state to functional components.
    // It returns an array with two elements: the current state value and a function to update that state value.
    //Eg : [0 , f]
    const [count , setCount] = useState(0); // Initializing count state variable to 0

    function incrementCounterFunction()
    {
        setCount(count + 1); //We are calling the setCount function to update the count state variable
    }

    return (
        <div className="Counter">
            <span className="count">{count}</span> 
            <div>
                <button className="counterButton" 
                onClick={incrementCounterFunction}
                // style = {buttonStyle}
                >+1 </button>
            </div>
        </div>
    );
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