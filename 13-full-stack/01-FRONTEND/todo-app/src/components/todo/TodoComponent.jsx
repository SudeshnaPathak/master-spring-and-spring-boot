import { useParams } from "react-router-dom"
import { retrieveTodoApi } from "./api/TodoApiService"
import { useEffect, useState } from "react"
import { useAuth } from "./security/AuthContext"
import { Field, Form, Formik } from "formik"

export default function TodoComponent(){
    const {id} = useParams()
    const authContext = useAuth()
    const username = authContext.username
    const [description , setDescription] = useState('')
    const [targetDate , setTargetDate] = useState('')

    useEffect( () => retrieveTodo() , [id] ) 

    function retrieveTodo(){
        retrieveTodoApi(username , id)
        .then( response => 
        {
            setDescription(response.data.description)
            setTargetDate(response.data.targetDate)
        })
        .catch( error => console.log(error))
    }
    
    //Formik is a library to handle forms in react easily
    //Whatever details we will submit in the form , will be captured in values, this is handled by formik
    function onSubmit(values){
        console.log(values)
    }

    return(
        <div className="container">
            <h1>Todo Component</h1>
            <div>
                <Formik initialValues={{description , targetDate}}
                    enableReinitialize={true}
                    onSubmit={onSubmit}
                    >                          
                    {
                       (props) => (
                        <Form>
                            <fieldset className="form-group">
                                <label>Description</label>
                                <Field type="text" className="form-control" name="description"></Field>
                            </fieldset>
                            <fieldset className="form-group">
                                <label>Target Date</label>
                                <Field type="date" className="form-control" name="targetDate"></Field>
                            </fieldset>
                            <div>
                                <button className="btn btn-success m-5" type="submit">Save</button>
                            </div>
                        </Form>
                       )
                    }
                </Formik>
            </div>
        </div>
    )
}

