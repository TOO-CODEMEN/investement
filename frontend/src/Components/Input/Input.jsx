import React from 'react'
import cl from './Input.module.css'

const Input = (props) => {
    return (
        <input className={cl.Input} onChange={(event) => props.setValue(event.target.value)}
            value={props.value}
            type={props.type}
            placeholder={props.placeholder} />
    )
}

export default Input