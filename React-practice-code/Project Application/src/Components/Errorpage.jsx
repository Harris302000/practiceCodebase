import React from "react";
import { BlinkBlur } from "react-loading-indicators";

const Errorpage = () => {
  return (
    <div style={{ width: "100%", height:'80vh', display:'flex',justifyContent:'center',alignItems:'center'}}>
      <center>
        <BlinkBlur
          color="#cc6231"
          size="medium"
          text="Page Not Found"
          textColor=""
        />
      </center>
    </div>
  );
};

export default Errorpage;
