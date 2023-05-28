import React from 'react'
import cl from './Checkbox.module.css'

const Checkbox = (props) => {
    return (
        <div>
            <input type="checkbox" className={cl.checkbox} id={props.id} name={props.name} checked={props.checked} onChange={
                () => {
                    props.setChange(!props.checked)
                    props.setCalcChange((value) => ({
                        ...value, 
                        ['typeOfOrganization']: !props.checked  ? "ИП" : "ООО (АО)"
                    }))
                }
            } />
            <label htmlFor={props.id} >{props.label} (В качестве изначального значения указано "OOO")</label>
        </div>
    )
}

export default Checkbox