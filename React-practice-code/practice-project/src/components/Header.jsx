import { useContext } from "react";
import { customContext } from "../App";




function Header() {


    let {userdets}  = useContext(customContext);
    console.log("Header->userdets::"+userdets);


    let data1 = `Welcome, ${userdets.uName}`;
    
    return(
        <h1>{data1}</h1>
    );

}

export default Header;