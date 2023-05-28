import React, { useState } from "react";
import cl from "./RequestItem.module.css"
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faChevronDown } from '@fortawesome/free-solid-svg-icons'

const AccordionItem = (props) => {
    const [visiblity, setVisiblity] = useState(false);

    const isActive = () => (props.multiple ? visiblity : props.active);

    const toogleVisiblity = () => {
        setVisiblity((v) => !v);
        props.onToggle();
    };

    return (
        <div className={isActive() ? `${cl.card} ${cl.accordionActive}` : `${cl.card}`}>
            <div className={cl.cardHeader} onClick={toogleVisiblity}>
                Запрос №{props.request.id}
                <div className={cl.Icons}>
                    <span className={isActive() ? `${cl.openIcon} ${cl.openIconActive}` : `${cl.openIcon}`}>
                        <FontAwesomeIcon icon={faChevronDown} />
                    </span>
                </div>
            </div>
            <div className={cl.cardBody}>
                <p><b>Отрасль ведения хоз.деятельности:</b> {props.request.industry}</p>
                <p><b>Штатная численность сотрудников:</b> {props.request.headcount}</p>
                <p><b>Предполагаемая площадь земельного участка для расположения промышленного производства (в кв. м):</b> {props.request.productionSquare}</p>
                <p><b>Планируемая площадь объектов капитального строительства:</b> {props.request.plannedAreaOfConstruction}</p>
                <p><b>Предполагаемое к использованию оборудование:</b> {props.request.equipment}</p>
                <p><b>Территория расположения объекта:</b> {props.request.productionArea}</p>
                <p><b>Тип объекта:</b> {props.request.typeOfBuilding}</p>
                <p><b>Площадь объекта:</b> {props.request.squareOfBuilding}</p>
                <p><b>Тип организации:</b> {props.request.typeOfOrganization}</p>
            </div>
        </div>
    )
}

export default AccordionItem