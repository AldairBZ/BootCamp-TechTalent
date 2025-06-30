document.addEventListener('DOMContentLoaded', () => {
    const tabs = document.querySelectorAll('.auth-tab');
    const forms = document.querySelectorAll('.auth-form');

    if (tabs.length === 0 || forms.length === 0) {
        return;
    }

    tabs.forEach(tab => {
        tab.addEventListener('click', () => {
            // Deactivate all tabs and forms
            tabs.forEach(item => item.classList.remove('active'));
            forms.forEach(form => form.classList.remove('active'));
            
            // Activate the clicked tab and corresponding form
            tab.classList.add('active');
            const formId = tab.dataset.form;
            if (formId) {
                const form = document.getElementById(formId);
                if (form) {
                    form.classList.add('active');
                }
            }
        });
    });
}); 