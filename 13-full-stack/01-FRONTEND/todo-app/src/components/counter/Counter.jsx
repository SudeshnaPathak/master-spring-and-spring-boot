export default function Counter()
{
    function incrementCounterFunction()
    {
        console.log("Increment Counter Clicked");
    }

    return (
        <div className="Counter">
            <span className="count">0</span> 
            <div>
                <button className="counterButton" onClick={incrementCounterFunction}> +1 </button> {/* If we use parentheses here like incrementCounterFunction() , the function will be called during the rendering itself which is not what we want. We want to call it only when the button is clicked. */}
            </div>
        </div>
    );
}