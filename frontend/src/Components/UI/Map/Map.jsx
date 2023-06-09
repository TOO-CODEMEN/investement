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
                        } key={el.id} />
                    ))}
                    <ZoomControl options={{ float: "right" }} />
                </Map>
            </YMaps>

            <ul style={{ display: 'flex', flexDirection: 'column', flexWrap: "wrap", marginTop: 10, height: 150 }}>
                {placemarks.map(el => (
                    <li key={el.id}>
                        <button onClick={() => onClickSubmit(el.name)} style={{
                            color: '#fff',
                            borderRadius: '5px',
                            backgroundColor: '#CC2222',
                            padding: '5px',
                            marginBottom: '10px',
                            cursor: 'pointer'
                        }}>
                            {el.name}
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    )

}