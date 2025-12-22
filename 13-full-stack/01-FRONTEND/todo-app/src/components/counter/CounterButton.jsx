export default function CounterButton({by = 1 , incrementMethod, decrementMethod}) //->Props 
{

    return (
        <div className="CounterButton">
            <div>
                <button className="counterButton" 
                        onClick={() => incrementMethod(by)}>
                +{by} </button>
                <button className="counterButton" 
                        onClick={() => decrementMethod(by)}>
                -{by} </button>
            </div>
        </div>
    )

}

// onClick() => Logic inside arrow function is executed only when the button is clicked

// If we use onClick={incrementMethod(by)} , the incrementMethod function will be executed immediately when the component is rendered, which is not what we want. We want it to be executed only when the button is clicked. Hence we use an arrow function to wrap the function call.

// Destructuring props object to directly get by, incrementMethod and decrementMethod
// Setting default value of by to 1 in case it is not passed from parent component







