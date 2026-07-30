/**
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {
      return new Promise(resolve => setTimeout(resolve, millis));
      // working
      let t = Date.now();
sleep(100).then(() => {
  console.log(Date.now() - t);
});

sleep(200).then(() => {
  console.log("Done after 200ms");
});

}

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */