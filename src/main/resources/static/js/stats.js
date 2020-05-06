console.log('Working!!!')

const yearSelect = document.querySelector('#year-select');
const yearBtn = document.querySelector('year-confirm-btn');

yearSelect.addEventListener('change', e => {
    console.log(yearSelect.value)
});