import React from 'react'
import cl from './Checkbox.module.css'

const Checkbox = (props) => {
    return (
        <div>
            <input type="checkbox" className={cl.checkbox} id={props.id} name={props.name} value={props.value} checked={props.checked} onChange={props.onChange}></input>
            <label htmlFor={props.id} >{props.label}</label>
        </div>
    )
}

export default Checkbox