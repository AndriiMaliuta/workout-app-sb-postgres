console.log('Working!!!')

const yearSelect = document.querySelector('#year-select');
const yearBtn = document.querySelector('year-confirm-btn');

yearSelect.addEventListener('change', e => {
    fetch(`/api/v1/workouts/year/${yearSelect.value}`)
        .then(response => response.json())
        .then(data => {
            console.log(data)
        });

});