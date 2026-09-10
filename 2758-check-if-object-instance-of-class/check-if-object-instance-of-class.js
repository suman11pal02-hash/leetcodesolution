/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
       if(obj === null || obj === undefined){
        return false;
    }

    if(typeof classFunction !== "function"){
        return false;
    }

    // Check primitive values
    const type = typeof obj;
    if(type !== "object" && type !== "function")
    {
        obj = Object(obj);
    }
    let proto= Object.getPrototypeOf(obj);
    const targetProto = classFunction.prototype;

    while (proto !== null)
    {
        if(proto === targetProto){
            return true;
        }

        proto = Object.getPrototypeOf(proto);
    }

    return false;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */