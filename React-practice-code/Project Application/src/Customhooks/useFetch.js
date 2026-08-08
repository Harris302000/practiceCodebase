import React, { useEffect, useState } from 'react';
import Axios from 'axios'

const useFetch = (url) => {

    let [product, setProduct] = useState([]);
    let [error, setError] = useState(false);
    let [isLoading, setIsLoading] = useState(true);


    useEffect(() => {


        let fetchData = async () => {
            console.log("calling fetchData");


            //Using Fetch API
            // let data = await fetch(url, { Method: "GET" })
            //     .then((Response) => {
            //         if (!Response.ok) {
            //             throw new error();
            //         }

            //         return Response.json();
            //     })
            //     .then((data) => {
            //         setProduct(data);
            //     })
            //     .catch((error) => setError(true))
            //     .finally(() => setIsLoading(false));

            //using axios
            try {

                let Response = await Axios.get(url)
                console.log(Response);

                let data = Response.data
                setProduct(data);

            } catch (error) {
                setError(true)
            } finally {
                setIsLoading(false)
            }

            

            console.log("End of fetchData");

        }

        fetchData();
    }, []);


    return { product, error, isLoading };

}

export default useFetch