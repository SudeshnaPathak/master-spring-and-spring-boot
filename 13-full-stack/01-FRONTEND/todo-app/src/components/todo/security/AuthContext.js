import { createContext, useState } from "react";

//1. Create a context
export const AuthContext = createContext();  //hook to create a context , default value is null

//2. Create AuthProvider component to share the context with all it's child components
export default function AuthProvider({ children }) { //children -> all the child components that are wrapped inside AuthProvider

    //3. Put some state in the context
    const [number , setNumber] = useState(10)

    return(
        <AuthContext.Provider value={{number}}>
            {children}
        </AuthContext.Provider>
    )
}

