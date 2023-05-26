import React from 'react'
import { YMaps, Map, Placemark, ZoomControl } from '@pbe/react-yandex-maps';


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

    const placemarks = [
        {
            name: 'ВАО',
            coor: [55.8049963, 37.6527668]
        },
        {
            name: 'ЗАО',
            coor: [55.6935446,36.951002]
        },
        {
            name: 'ЗелАО',
            coor: [55.986412,37.1197127]
        },
        {
            name: 'НАО',
            coor: [55.5497755,37.0550174]
        },
        {
            name: 'САО',
            coor: [55.8587039,37.2976006]
        },
        {
            name: 'СВАО',
            coor: [55.8697214,37.4616571]
        },
        {
            name: 'СЗАО',
            coor: [55.8265044,37.2628915]
        },
        {
            name: 'ТАО',
            coor: [55.3509711,36.8074438]
        },
        {
            name: 'ЦАО',
            coor: [55.7536404,37.5315224]
        },
        {
            name: 'ЮАО',
            coor: [55.6480966,37.5167426]
        },
        {
            name: 'ЮВАО',
            coor: [55.6992192,37.6494372]
        },
        {
            name: 'ЮЗАО',
            coor: [55.601187,37.3701247]
        },
    ]

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
                            iconContent: el.name,
                            hintContent: el.name
                        }
                    } />
                ))}
                <ZoomControl options={{ float: "right" }} />
            </Map>
        </YMaps>
    );
}