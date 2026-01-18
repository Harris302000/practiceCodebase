function Hero() {
    return (

      <div className="home-layout">
        <section>
          <h1>Welcome to My Company</h1>
          <p>We provide best IT solutions for your business.</p>
          
          <div className="hero-input">
            <label htmlFor="email">Email Address:</label>
            <input
              id="email"
              type="text"
              placeholder="Enter your email"
            />
          </div>
          <br/>
          <button>Get Started</button>

        </section>
      </div>


      
    );
  }
  
  export default Hero;
  