import FirstComponent from './FirstComponent';
import SecondComponent from './SecondComponent';
import ThirdComponent from './ThirdComponent';
import FourthComponent from './FourthComponent';
import { FifthComponent } from './FirstComponent';
//{} are used to import non-default exports ->Named imports
import LearningJavaScript from './LearningJavaScript';

export default function LearningComponent(){

    //JSX Elements must have closing tags
    //return() : parenthesis makes it easy to write multi-line JSX ~ Why Parenthesis?
    //lowercase tag names refer to HTML elements
    //Uppercase Component names refer to user-defined components
    //We return JSX view from here which will be displayed by this component

    return(
        <div className="LearningComponent">
            <FirstComponent />
            <SecondComponent />
            <ThirdComponent />
            <FourthComponent />
            <FifthComponent />
            <LearningJavaScript />
        </div> // JSX element/tag
    );
}