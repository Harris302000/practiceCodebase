function Content() {

  return (
    <>
      <main>
         <aside>
          <h3>Recent Posts</h3>
          <p>Java Basics</p>
          <p>Spring Boot</p>
          <p>Microservices</p>
        </aside>
        
        <section>
          <h2>Latest Articles</h2>

          <article>
            <h3>Java 8 Features</h3>
            <p>
              Java 8 introduced Lambda Expressions, Streams,
              Optional and Functional Interfaces.
            </p>
          </article>

          <article>
            <h3>Spring Boot</h3>
            <p>
              Spring Boot helps us create Java applications
              with less configuration.
            </p>
          </article>
        </section>

      </main>

      <div className="login-container">
        <h3>Login Page</h3>
        <div id="login-input-div">
          <input type="text" id="login-username" placeholder="Enter Username" />
          <input type="text" id="login-password" placeholder="Enter Password" />
        </div>
        <div id="login-button-div">
          <button>Login</button>
          <a href="https://www.google.com/aclk?sa=L&pf=1&ai=DChsSEwj5zr7P2oKWAxU2HYMDHR0kGUMYACICCAEQABoCc2Y&co=1&ase=2&gclid=CjwKCAjw1bvTBhBbEiwAzbP8LxKn21b17ByfELMaqVv37XMhb4h9pZIJT556YfLB1J_uJX7WqkLlqRoCUZ0QAvD_BwE&cid=CAASugHkaJJrN-xxr9xMGSoxwuncetdFHz_nChtNPY7VTstpPQsGcWUC3sPfJ7mp-Ql-fV_DLGmSjSyTGLgGLgu7ouoB24Bc7NhZ8Ntv9T5VLusuBb3e_3WUvuE54QiMSt9zlWr3JIH_mHE_PzOIdSCx8U5QAsuMuE22RzBaHBBPT_MqGxPcHQ6Y5ozVSHGxAL2_kTQxTqMxo5FWbVOYWzqwE-a0PXYSBDLaSX8G_aemY46Jq8wYDOGHERO4Gu4&cce=2&category=acrcp_v1_32&sig=AOD64_3aAWELtc_MwDqxcpKPoVuIuzB15Q&q&nis=4&adurl=https://www.flipkart.com/?affid%3Drohanpouri%26affExtParam1%3DENKR20260730A2102387167%26affExtParam2%3D4203077%26gad_source%3D1%26gad_campaignid%3D23971930224%26gbraid%3D0AAAAA_HKgsQ6UiRU6lySMvso8IEZKS0CC%26gclid%3DCjwKCAjw1bvTBhBbEiwAzbP8LxKn21b17ByfELMaqVv37XMhb4h9pZIJT556YfLB1J_uJX7WqkLlqRoCUZ0QAvD_BwE&ved=2ahUKEwjc2rrP2oKWAxWDSWwGHRlzLcsQ0Qx6BAgMEAE" style={{ textDecoration: "none" }}>
            Forget Password?
          </a>
        </div>
      </div>

    </>
  );

}


export default Content;