import './Counter.css';

export default function Counter()
{
    function incrementCounterFunction()
    {
        console.log("Increment Counter Clicked")
    }

    // const buttonStyle = {
    //     'fontSize' : '16px',
    //     'backgroundColor' : '#00a5ab',
    //     'width' : '100px',
    //     'margin' : '10px',          
    //     'color' : 'white',
    //     'padding' : '15px',
    //     'borderRadius' : '30px'
    // }

    return (
        <div className="Counter">
            <span className="count">0</span> 
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
// 2. Using inline styles 

// style attribute in JSX takes a JavaScript object instead of a string as in HTML. Hence we define buttonStyle as an object and pass it to the style attribute.