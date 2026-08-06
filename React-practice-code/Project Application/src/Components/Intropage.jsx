import React from "react";
import { useParams } from "react-router-dom";

const Intropage = () => {
  let { username } = useParams();
  console.log(username);

  return (
    <div>
      <h1>Hi, {username}</h1>
      <h2>Welcome To the Introduction</h2>
    </div>
  );
};

export default Intropage;
