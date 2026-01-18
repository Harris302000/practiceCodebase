function MandatoryLabel({ htmlFor, children, mandatory }) {
    return (
      <label htmlFor={htmlFor}>
        {children}
        {mandatory && <span className="mandatory">*</span>}
      </label>
    );
  }


  export const validateMandatoryFields = () => {
    const inputs = document.querySelectorAll("input[data-mandatory='true']");
  
    for (let input of inputs) {
      if (!input.value) {
        input.focus();
        return false;
      }
    }
    return true;
  };
  
  
  export default MandatoryLabel;
  