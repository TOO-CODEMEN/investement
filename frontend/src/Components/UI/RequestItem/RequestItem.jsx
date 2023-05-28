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
                <p>Отрасль ведения хоз.деятельности: {props.request.industry}</p>
                <p>Штатная численность сотрудников: {props.request.headcount}</p>
                <p>Предполагаемая площадь земельного участка для расположения промышленного производства (в кв. м): {props.request.productionSquare}</p>
                <p>Планируемая площадь объектов капитального строительства: {props.request.plannedAreaOfConstruction}</p>
                <p>Предполагаемое к использованию оборудование: {props.request.equipment}</p>
                <p>Территория расположения объекта: {props.request.productionArea}</p>
                <p>Тип объекта: {props.request.typeOfBuilding}</p>
                <p>Площадь объекта: {props.request.squareOfBuilding}</p>
                <p>Тип организации: {props.request.typeOfOrganization}</p>
            </div>
        </div>
    )
}

export default AccordionItem