console.log('Working!!!')

const yearSelect = document.querySelector('#year-select');
const yearSpan = document.querySelector('#year-span')

yearSelect.addEventListener('change', e => {
    fetch(`/api/v1/workouts/year/${yearSelect.value}`)
        .then(response => response.json())
        .then(data => {

        });

});