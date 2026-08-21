import React from "react";
import Button from "react-bootstrap/Button";
import img1 from "../assets/Images/Harris_IMG.JPG";
import {Link} from "react-router-dom";

const Home = () => {
  return (
    <div className="Home-Div bg-yellow-900 min-h-screen">
      <section className="flex-col md:flex-row">
        <div className=" w-[90%] md:w-[70%] flex flex-col justify-center items-center h-[45vh] md:h-[80vh]" 
        // style={{ width: "70%",height : '80vh',display:'flex',flexDirection:'column',justifyContent:'center',alignItems:'center'}}
        >
          <h2 className="!text-amber-300" >Hi, I'm Agnes Harris Fernando</h2>
          <h4 className="!text-amber-300">Java Full Stack Developer</h4>
          <p className="text-red-300 sm:text-amber-300 font-bold font-sans sd:text-[18px] w-[90%] md:w-[70%] py-[40px]" 
          // style={{width : '70%',padding: '40px 0px'}}
          >
            I’m a Java Developer with 4+ years of experience, primarily in the
            banking domain. I have strong experience in Core Java, Spring Boot,
            REST APIs, SQL, and microservices, and I’ve worked on Loan
            Origination Systems involving end-to-end application development and
            integration. I also have working knowledge of React.js and
            experience collaborating with clients, business analysts, and QA
            teams.
          </p>
          <div
            style={{
              display: "flex",
              justifyContent: "space-between",
              width: "300px",
            }}
          >
            <Button  as={Link} to={"/projects"} variant="primary">View My Projects</Button>
            <Button  as={Link} to={"/contact"} variant="primary">Contact Me</Button>
          </div>
        </div>

        <div className="flex-1 pt-8 md:pt-0">
            <img src={img1} alt="Image not found" className="w-[300px]" />
          </div>
      </section>
    </div>
  );
};

export default Home;
