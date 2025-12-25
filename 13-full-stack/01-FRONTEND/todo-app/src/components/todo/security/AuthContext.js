import { createContext, useContext, useState } from "react";

//1. Create a context
export const AuthContext = createContext();  //hook to create a context , default value is null
export const useAuth = () => useContext(AuthContext) //hook to consume the context

//2. Create AuthProvider component to share the context with all it's child components
export default function AuthProvider({ children }) { //children -> all the child components that are wrapped inside AuthProvider

    //3. Put some state in the context
    const [number , setNumber] = useState(10)
    const [isAuthenticated , setAuthenticated] = useState(false)

    // setInterval(
    //     () => setNumber( number + 1), 10000
    // )

    return(
        <AuthContext.Provider value={{ number , isAuthenticated , setAuthenticated }}>
            {children}
        </AuthContext.Provider>
    )
}

