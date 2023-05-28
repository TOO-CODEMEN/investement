import React from 'react'
import cl from './Input.module.css'

const Input = (props) => {

    if (props.type === 'number') {

        return (
            <div>
                <label>
                    {props.label}
                </label>
                <input className={cl.Input} onChange={(event) => (

                    props.setValue(typeof props.object == "object" ? (value) => (
                        {
                            ...value,
                            [props.typeObject]: event.target.value
                        }
                    ) : event.target.value))}
                    value={props.value}
                    type={props.type}

                    min='0'
                />
            </div>
        )

    }

    return (
        <div>
            <label>
                {props.label}
            </label>
            <input className={cl.Input} onChange={(event) => (

                props.setValue(typeof props.object == "object" ? (value) => (
                    {
                        ...value,
                        [props.typeObject]: event.target.value
                    }
                ) : event.target.value))}
                value={props.value}
                type={props.type}
            />
        </div>
    )
}

export default Input