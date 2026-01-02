import { createContext, useContext, useState } from "react";
import { executeJWTAuthenticationService } from "../api/AuthenticationApiService.js";
import { apiClient } from "../api/ApiClient";

//1. Create a context
export const AuthContext = createContext();  //hook to create a context , default value is null
export const useAuth = () => useContext(AuthContext) //hook to consume the context

//2. Create AuthProvider component to share the context with all it's child components
export default function AuthProvider({ children }) { //children -> all the child components that are wrapped inside AuthProvider

    //3. Put some state in the context
    const [isAuthenticated , setAuthenticated] = useState(false)
    const [username , setUsername] = useState(null)
    const [token , setToken] = useState(null)

    //Uncomment this for dummy authentication w/o Spring Security 
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


    // async function login(username , password){

    //     const baToken = 'Basic ' + window.btoa(username + ':' + password) //Base64 encoding of username and password

    //     //async await pattern , where await is used to wait for the call to complete and return the response
    //     //and ensure that the code is executed in sequence

    //     try{
    //         const response = await executeBasicAuthenticationService(baToken)

    //         if(response.status === 200){
    //             setAuthenticated(true)
    //             setUsername(username)
    //             setToken(baToken)
    //             //Intercepting every request to add Authorization header
    //             apiClient.interceptors.request.use(
    //                 (config) => {
    //                     console.log('intercepting and adding a token')
    //                     config.headers.Authorization = baToken
    //                     return config
    //                 }
    //             )
    //             return true
    //         } else {
    //             logout()
    //             return false
    //         }

    //     }catch(error){
    //         logout()
    //         return false
    //     }
       
    // }

    async function login(username , password){

        //async await pattern , where await is used to wait for the call to complete and return the response
        //and ensure that the code is executed in sequence

        try{
            const response = await executeJWTAuthenticationService(username , password)

            if(response.status === 200){
                const jwtToken = 'Bearer ' + response.data.token
                setAuthenticated(true)
                setUsername(username)
                setToken(jwtToken)
                //Intercepting every request to add Authorization header
                apiClient.interceptors.request.use(
                    (config) => {
                        console.log('intercepting and adding a token')
                        config.headers.Authorization = jwtToken
                        return config
                    }
                )
                return true
            } else {
                logout()
                return false
            }

        }catch(error){
            logout()
            return false
        }
       
    }

    function logout(){
        setAuthenticated(false)
        setUsername(null)
        setToken(null)
    }

    return(
        <AuthContext.Provider value={{isAuthenticated , username , token , login , logout}}>
            {children}
        </AuthContext.Provider>
    )
}

