import React from 'react'
import { YMaps, Map, Placemark, ZoomControl } from '@pbe/react-yandex-maps';
import { placemarks } from '../../../data/data';

import { defaultState } from '../../../data/data';


export const MapForm = (props) => {

    const onClickSubmit = (nameAdmin) => {
        props.setValue((value) => ({
            ...value,
            [props.typeObject]: nameAdmin
        }))

        props.setActive(false)
    }

    return (
        <div>
            <YMaps>
                <Map defaultState={defaultState}>
                    {placemarks.map(el => (
                        <Placemark geometry={el.coor} onClick={
                            () => onClickSubmit(el.name)
                        } options={{
                            iconColor: "#CC2222",
                            hasHint: true,
                            openHintOnHover: true,
                        }} properties={
                            {
                                iconCaption: el.name,
                            }
                        } key={el.id}/>
                    ))}
                    <ZoomControl options={{ float: "right" }} />
                </Map>
            </YMaps>

            <ul style={{display: 'flex', flexDirection: 'column', flexWrap: "wrap"}}>
                {placemarks.map(el => (
                    <li key={el.id}>
                        <button onClick={() => onClickSubmit(el.name)} className='okrug'>
                            {el.name}
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    )

}