import { createContext, useContext, useState } from "react";
import { executeBasicAuthenticationService } from "../api/HelloWorldApiService";

//1. Create a context
export const AuthContext = createContext();  //hook to create a context , default value is null
export const useAuth = () => useContext(AuthContext) //hook to consume the context

//2. Create AuthProvider component to share the context with all it's child components
export default function AuthProvider({ children }) { //children -> all the child components that are wrapped inside AuthProvider

    //3. Put some state in the context
    const [isAuthenticated , setAuthenticated] = useState(false)
    const [username , setUsername] = useState(null)

    // function login(username , password){
    //     if(username==='Sudeshna' && password==='dummy'){
    //         setAuthenticated(true)
    //         setUsername(username)
    //         return true
    //     } else {
    //         setAuthenticated(false)
    //         setUsername(null)
    //         return false
    //     }
    // }


    function login(username , password){

        const baToken = 'Basic ' + window.btoa(username + ':' + password) //Base64 encoding of username and password

        executeBasicAuthenticationService(baToken)
        .then( response => console.log(response))
        .catch( error => console.log(error))
        
        setAuthenticated(false)
    }

    function logout(){
        setAuthenticated(false)
    }

    return(
        <AuthContext.Provider value={{isAuthenticated , username , login , logout}}>
            {children}
        </AuthContext.Provider>
    )
}

