Feature: homePage

  @day1
  Scenario: As a user, on the footer of the page I should be able to see the Explore, Features,Company Titles and related subtitles._1
    Given go to website "https://test.hypnotes.net/"
    And go to bottom page
    Then assert titles are displayed
      | Blog                                                                   |
      | Pricing                                                                |
      | How It Works ?                                                         |
      | Appointment Scheduling                                                 |
      | Secure Video Conferencing                                              |
      | ESign Documents Online                                                 |
      | Billing & Invoicing                                                    |
      | Biofeedback-Emotion Recognition                                        |
      | Speech To Text - Voice Note                                            |
      | Handwriting To Text - OCR                                              |
      | Customize Service                                                      |
      | Get Organized                                                          |
      | Security-HIPAA Compliance                                              |
      | Website Builder                                                        |
      | About Us                                                               |
      | Contact Us                                                             |
      | Privacy Policy                                                         |
      | Terms Of Service                                                       |
      | Hypnotes Inc., 1159 Kelez Dr San Jose, California, 95120, United States |
      | +1 (831) 205-7059                                                      |

  @day1
  Scenario Outline: US_011_TC02 The user verifies that the Headings in the relevant section should be clickable and related pages should be opened
    Given go to website "https://test.hypnotes.net/"
    And go to bottom page
    When the user clicks "<index>" the link and verifies that the url is the expected "<url>"
    Examples:
      | index | url                                                                   |
      | 0     | https://test.hypnotes.net/blog                                        |
      | 1     | https://test.hypnotes.net/pricing                                     |
      | 2     | https://test.hypnotes.net/how-it-works                                |
      | 3     | https://test.hypnotes.net/features/therapy-appointment-scheduling     |
      | 4     | https://test.hypnotes.net/features/telehealth-video-conferencing      |
      | 5     | https://test.hypnotes.net/features/esign-documents-online             |
      | 6     | https://test.hypnotes.net/features/billing-software-for-therapists    |
      | 7     | https://test.hypnotes.net/features/biofeedback-ai-emotion-recognition |
      | 8     | https://test.hypnotes.net/features/speech-to-text                     |
      | 9     | https://test.hypnotes.net/features/ocr-handwriting-to-text            |
      | 10    | https://test.hypnotes.net/features/customize-service                  |
      | 11    | https://test.hypnotes.net/features/get-organized                      |
      | 12    | https://test.hypnotes.net/features/hipaa-security                     |
      | 13    | https://test.hypnotes.net/services/therapist-website-builder          |
      | 14    | https://test.hypnotes.net/about-us                                    |
      | 15    | https://test.hypnotes.net/contact-us                                  |
      | 16    | https://test.hypnotes.net/privacy-policy                              |
      | 17    | https://test.hypnotes.net/terms-of-service                            |












