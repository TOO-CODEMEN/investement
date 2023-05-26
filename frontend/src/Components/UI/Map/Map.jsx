import React from 'react'
import { YMaps, Map, Placemark, ZoomControl } from '@pbe/react-yandex-maps';
import { placemarks } from '../../../data/data';


export const MapForm = (props) => {
    const defaultState = {
        center: [55.751574, 37.573856],
        zoom: 6,
    };

    const onClickSubmit = (nameAdmin) => {
        props.setValue((value) => ({
            ...value,
            [props.typeObject]: nameAdmin
        }))

        props.setActive(false)
    }

    return (
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
                    }/>
                ))}
                <ZoomControl options={{ float: "right" }} />
            </Map>
        </YMaps>
    );
}