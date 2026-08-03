import "../CSS/signin-styles.css";
import logo from "../assets/Images/naukriLogo.svg";
import lpImg1 from "../assets/Images/leftpane-img1.png";

function Signin() {
  return (
    <>
      <header>
        <img src={logo} alt="img not found" />
        <p>
          Already Registered?{" "}
          <a href="" style={{ textDecoration: "none", color: "blue" }}>
            Login
          </a>{" "}
          here
        </p>
      </header>

      <main>
        <div id="panel-1">
          <img src={lpImg1} id="lpImg1" alt="img not found" />
          <h3>On regstering, you can</h3>
          <ul>
            <li>Build your profile and let recuriters find you</li>
            <li>Get job openings delivered right to your email</li>
            <li>Find a job and grow your career</li>
          </ul>
        </div>

        <div id="panel-2">
          <div>
            <h3>Create your Naukri profile</h3>
            <p>Search & apply to jobs from India's No.1 Job Site</p>
          </div>

          <form className="input-main-div">
            <div className="input-div">
              <label htmlFor="username">Full Name<span>*</span></label>
              <input
                type="text"
                id="username"
                autoComplete="name"
                placeholder="What is your name?"
              />
              <p></p>
            </div>

            <div className="input-div">
              <label htmlFor="emailid">Email ID<span>*</span></label>
              <input
                type="email"
                id="emailid"
                autoComplete="email"
                placeholder="Tell us your Email ID"
              />
              <p>We'll send relevant jobs and updates to this email</p>
            </div>

            <div className="input-div">
              <label htmlFor="Password">Password<span>*</span></label>
              <input
                type="password"
                id="Password"
                autoComplete="new-password"
                placeholder="(Minimum 6 characters)"
              />
              <p>This helps your account stay protected</p>
            </div>

            <div className="input-div">
              <label htmlFor="mobNumber">Mobile number<span>*</span></label>
              <input
                type="tel"
                id="mobNumber"
                autoComplete="tel"
                placeholder="Enter mobile number"
              />
              <p>Recruiters will contact you on this number</p>
            </div>

            <div className="work-status">
              <label>
                Work status<span>*</span>
              </label>

              <div className="work-options">
                <label className="work-card">
                  <input type="radio" name="workStatus" value="experienced" />

                  <div>
                    <h3>I'm experienced</h3>
                    <p>
                      I have work experience
                      <br />
                      (excluding internships)
                    </p>
                  </div>

                  {/* <img src={experiencedImg} alt="" /> */}
                </label>

                <label className="work-card">
                  <input type="radio" name="workStatus" value="fresher" />

                  <div>
                    <h3>I'm a fresher</h3>
                    <p>
                      I am a student/ Haven't worked
                      <br />
                      after graduation
                    </p>
                  </div>

                  {/* <img src={fresherImg} alt="" /> */}
                </label>
              </div>
            </div>
          </form>
        </div>
      </main>
    </>
  );
}

export default Signin;
