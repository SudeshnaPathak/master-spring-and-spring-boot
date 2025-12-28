import { useEffect, useState } from "react"
import { retrieveAllTodosForUsername } from "./api/TodoApiService"

export default function ListTodosComponent(){

    // const today = new Date()
    // const targetDate = new Date(today.getFullYear()+12 , today.getMonth() , today.getDay())
    // const todos = [
    //                 {id : 1 , description : 'Learn AWS' , done : false , targetDate : targetDate},
    //                 {id : 2 , description : 'Learn DevOps', done : false , targetDate : targetDate},
    //                 {id : 3 , description : 'Learn Full Stack Development' , done : false , targetDate : targetDate}
    // ]

    const[todos , setTodos] = useState([])
    
    //UseEffect hook to call refreshTodos as soon as the component is loaded 
    // [] ensures it runs only once , i.e when the component is loaded
    useEffect(() => refreshTodos() , []) 

    function refreshTodos(){
        retrieveAllTodosForUsername('Sudeshna')
        .then(response => setTodos(response.data))
        .catch(error => console.log(error))
    }
    
    return(
        <div className="container">
           <h1>Things You want to Do!</h1>
           <div>
                <table className="table">
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>Description</td>
                            <td>Is Done?</td>
                            <td>Target Date</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(
                                todo =>(
                                    <tr key={todo.id}>
                                        <td>{todo.id}</td>
                                        <td>{todo.description}</td>
                                        <td>{todo.done.toString()}</td>
                                        <td>{todo.targetDate}</td>
                                    </tr>
                                )
                            )
                        }  
                    </tbody>
                </table>
           </div>
        </div>
    )
}