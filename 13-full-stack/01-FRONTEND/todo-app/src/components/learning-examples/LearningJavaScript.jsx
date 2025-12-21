const Person = {
    'name' : 'Sudeshna Pathak',
    'address' : {
        'line1' : 'J.C.Mallick Road',
        'city' : 'Dhanbad',
        'state' : 'Jharkhand',
        'country' : 'India'
    },
    'profiles' : ['GitHub', 'LinkedIn', 'Instagram'],
    'PrintProfiles' : () => {
        Person.profiles.map(
            profile => console.log(profile)
        )
    }
} // JavaScript Objects ~ Dynamic Objects
// We can have functions as properties of objects in JavaScript

//Not necessary to use semicolon in javascript

export default function LearningJavaScript(){
    return(
        <>
            <div>{Person.name}</div>
            <div>{Person.address.line1}</div>
            <div>{Person.profiles[0]}</div>
            <div>{Person.PrintProfiles()}</div>
        </>
    );
}